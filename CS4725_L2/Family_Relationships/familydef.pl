parent(X,Y) :- mother(X,Y); father(X,Y).
child(X,Y) :- parent(Y,X).
sibling(X,Y) :- parent(A,X), parent(A,Y), (X \= Y).
grandparent(X,Y) :- parent(A,Y), parent(X,A).
greatgrandparent(X,Y) :- grandparent(A,Y), parent(X,A).
ancestor(X,Y) :- parent(Z,X), ancestor(Z,Y); parent(Y,X).
uncle(X,Y) :- parent(A,Y), sibling(X,A), male(X).
aunt(X,Y):- parent(A,Y), sibling(X,A), female(X).
nephew(X,Y):- sibling(A,Y), child(X,A), male(X).
niece(X,Y) :- sibling(A,Y), child(X,A), female(X).
firstcousin(X,Y) :- grandparent(A,X), grandparent(A,Y).
