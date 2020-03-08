family.pl       - Contains facts about several members in a hypothetical family, using the relations male, female, mother and father.
familydef.pl    - Provides the deﬁnitions for the relations below:
                    • parent(X,Y): true if X is Y’s parent
                    • child(X,Y): true if X is Y’s child
                    • sibling(X,Y): true if X and Y are diﬀerent people who have at least one parent in common
                    • grandparent(X,Y): true if X is Y’s grandparent
                    • greatgrandparent(X,Y): true if X is Y’s great-grandparent
                    • ancestor(X,Y): true if X is a direct ancestor of Y (parent, grandparent, greatgrandparent, great-great-grandparent, etc.) – See the note below.
                    • uncle(X,Y): true if X is a brother of one of Y’s parents
                    • aunt(X,Y): true if X is a sister of one of Y’s parents
                    • nephew(X,Y): true if X is a male child of a sibling of Y
                    • niece(X,Y): true if X is a female child of a sibling of Y
                    • firstcousin(X,Y): true if X and Y are children of siblings

Can load the deﬁnitions from both family.pl and familydef.pl into gprolog at the same time by typing ‘[family,familydef].’

Notes:
• For the ancestor relation, want to make sure that it will work no matter how many generations apart two individuals are. In our example family.pl ﬁle, there are no instances of great-great-great-grandparents or great-great-great-great-greatgreat-grandparents, but you want your ancestor relation to work correctly if there are such relationships provided for a diﬀerent family. You should consider using a recursive approach to deﬁning the ancestor relation.
• It is ﬁne if some pairs of people are returned more than once in a list of solutions. For example, X = matt, Y = dan might be returned as siblings because they share the same mother and then again because they share the same father. We won’t worry about preventing this duplication.