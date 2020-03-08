num(1).
num(2).
num(3).
num(4).
num(5).
num(6).
num(7).
num(8).
num(9).

valid(R,S,T,U,V,W,X,Y,Z) :- num(R), num(S), num(T), num(U), num(V), num(W), num(X), num(Y), num(Z), fd_all_different([R,S,T,U,V,W,X,Y,Z]).

samesum(A,B,C,D,E,F,G,H,I) :- A+B+C =:= D+E+F,
															D+E+F =:= G+H+I,
															G+H+I =:= A+D+G,
															A+D+G =:= B+E+H,
															B+E+H =:= C+F+I,
															C+F+I =:= A+E+I,
															A+E+I =:= G+E+C.

solution(A,B,C,
	 D,E,F,
	 G,H,I) :- num(A), num(B), num(C), num(E), num(F), num(G), num(H), num(I),
		valid(A,B,C,D,E,F,G,H,I), samesum(A,B,C,D,E,F,G,H,I).
