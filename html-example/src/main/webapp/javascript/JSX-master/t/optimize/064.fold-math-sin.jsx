/*EXPECTED
0
*/
/*JSX_OPTS
--optimize fold-const
*/
class _Main {
	static function main (args : string[]) : void {
		log Math.sin(0);;
	}
}
