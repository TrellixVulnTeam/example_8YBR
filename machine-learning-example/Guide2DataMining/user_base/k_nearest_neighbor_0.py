#!/usr/bin/python
# -*- coding: utf-8 -*-

from __future__ import division
from __future__ import print_function
from math import sqrt

class Recommender(object):
    def __init__(self, data, k=1, n=5, metric='pearson'):
        if type(data).__name__ == 'dict':
            self.data = data
        self.k = k
        self.n = n
        if metric == 'pearson':
            self.fn = self.pearson
#         self.username2id = {}
#         self.userid2name = {}
#         self.productid2name = {}
#         self.metric = metric 
        
    def pearson(self, rating1, rating2):
        sum_xy = 0
        sum_x = 0
        sum_y = 0
        sum_x2 = 0
        sum_y2 = 0
        n = 0
        for key in rating1:
            if key in rating2:
                n += 1
                x = rating1[key]
                y = rating2[key]
                sum_xy += x * y
                sum_x += x
                sum_y += y
                sum_x2 += x**2
                sum_y2 += y**2
        if n == 0:
            return 0
        denominator = sqrt(sum_x2 - (sum_x**2) / n) * sqrt(sum_y2 - (sum_y**2) / n)
        if denominator == 0:
            return 0
        return (sum_xy - (sum_x * sum_y) / n) / denominator
    
    def computeNearestNeighbor(self, user):
        distances = []
        for instance in self.data:
            if instance != user:
                distance = self.fn(self.data[user], self.data[instance])
                distances.append((instance, distance))
        distances.sort(key=lambda artistTuple: artistTuple[1], reverse=True)
        return distances

    def recommend(self, user):
        recommendations = {}
        nearest = self.computeNearestNeighbor(user)
        userRatings = self.data[user]
        totalDistance = 0.0
        for i in range(self.k):
            totalDistance += nearest[i][1]
        for i in range(self.k):
            weight = nearest[i][1] / totalDistance
            name = nearest[i][0]
            neighborRatings = self.data[name]
            for artist in neighborRatings:
                if not artist in userRatings:
                    if artist not in recommendations:
                        recommendations[artist] = (neighborRatings[artist] * weight)
                    else:
                        recommendations[artist] = (recommendations[artist] + neighborRatings[artist] * weight)

        rec_list = list(recommendations.items())
        rec_list.sort(key=lambda artistTuple: artistTuple[1], reverse = True)
        return rec_list[:self.n]

if __name__ == '__main__':
    users = {"Angelica": {"Blues Traveler": 3.5, "Broken Bells": 2.0,
                      "Norah Jones": 4.5, "Phoenix": 5.0,
                      "Slightly Stoopid": 1.5,
                      "The Strokes": 2.5, "Vampire Weekend": 2.0},
         
         "Bill":{"Blues Traveler": 2.0, "Broken Bells": 3.5,
                 "Deadmau5": 4.0, "Phoenix": 2.0,
                 "Slightly Stoopid": 3.5, "Vampire Weekend": 3.0},
         
         "Chan": {"Blues Traveler": 5.0, "Broken Bells": 1.0,
                  "Deadmau5": 1.0, "Norah Jones": 3.0, "Phoenix": 5,
                  "Slightly Stoopid": 1.0},
         
         "Dan": {"Blues Traveler": 3.0, "Broken Bells": 4.0,
                 "Deadmau5": 4.5, "Phoenix": 3.0,
                 "Slightly Stoopid": 4.5, "The Strokes": 4.0,
                 "Vampire Weekend": 2.0},
         
         "Hailey": {"Broken Bells": 4.0, "Deadmau5": 1.0,
                    "Norah Jones": 4.0, "The Strokes": 4.0,
                    "Vampire Weekend": 1.0},
         
         "Jordyn":  {"Broken Bells": 4.5, "Deadmau5": 4.0,
                     "Norah Jones": 5.0, "Phoenix": 5.0,
                     "Slightly Stoopid": 4.5, "The Strokes": 4.0,
                     "Vampire Weekend": 4.0},
         
         "Sam": {"Blues Traveler": 5.0, "Broken Bells": 2.0,
                 "Norah Jones": 3.0, "Phoenix": 5.0,
                 "Slightly Stoopid": 4.0, "The Strokes": 5.0},
         
         "Veronica": {"Blues Traveler": 3.0, "Norah Jones": 5.0,
                      "Phoenix": 4.0, "Slightly Stoopid": 2.5,
                      "The Strokes": 3.0}
        }
    

    recommender = Recommender(users)
    print(recommender.recommend("Hailey"))
    