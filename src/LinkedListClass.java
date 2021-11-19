import java.util.Locale;

//REMEMBER: AFTER COMPLETING EACH CASE, TERMINATING IT BY "RETURN;"
//****************************************************************
public class LinkedListClass {
    public LLNode head;

    public LinkedListClass() {
        head = null;
    }

    public void addNode(LLNode node) {
        if (head == null) {
            LLNode categoryNode = new LLNode(node.getName().substring(0, 1), node);
            head = categoryNode;
            return;
        } else {
            //iterate the linked list to find when comparisionTo resulting in == -1
            LLNode cursor = head;
            if (node.aheadOfNode(cursor)) {
                LLNode categoryNode = new LLNode(node.getName().substring(0, 1), node);
                node.setLink(cursor);
                head = categoryNode;
                return;
            }


            boolean encoutneredCateogryNode = false;
            while (cursor != null) {
                LLNode next = cursor.getLink();
                if (encoutneredCateogryNode == false) {
                    encoutneredCateogryNode = isCategoryNodeForName(cursor, node.getName());
                }
                if (next == null) {
                    if (encoutneredCateogryNode) {
                        cursor.setLink(node);
                        node.setLink(next);
                    } else {
                        LLNode categoryNode = new LLNode(node.getName().substring(0, 1), node);
                        cursor.setLink(categoryNode);
                        node.setLink(next);
                    }
                    return;

                } else if (node.aheadOfNode(next)) {
                    if (encoutneredCateogryNode) {
                        cursor.setLink(node);
                        node.setLink(next);
                    } else {
                        LLNode categoryNode = new LLNode(node.getName().substring(0, 1), node);
                        cursor.setLink(categoryNode);
                        node.setLink(next);
                    }
                    return;
                }
                cursor = cursor.getLink();
            }
            //Have an boolean keeping track if encountering the letter Node
            //if next is null, add the category Node (if haven't encountered letter Node) and name Node at the end
            //if != -1 && already encountered the letter Node ==> add the name Node, if not encountered the letter Node ==> add the letter Node and the name Node
        }

    }

    private boolean isCategoryNodeForName(LLNode node, String name) {
        boolean test = ((node.getName().length() == 1) && (node.getName().toLowerCase().charAt(0) == name.toLowerCase().charAt(0)));
        return test;
    }


    public void add(String name) {
        LLNode newNode = new LLNode(name, null);
        addNode(newNode);
    }

    private boolean isCategoryNode(LLNode node) {
        return (node.getName().length() == 1);
    }

    public void reverseList() {
        LLNode prev = null;
        LLNode current = head;
        LLNode next = null;
        while (current != null) {
            next = current.getLink();
            current.setLink(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }


    /*   public void removeName(String name) {
           LLNode cursor = head;
           LLNode prev = null;
           while (cursor.getLink().getLink().getLink().getLink()!= null) {
               if (name.equals(cursor.getLink().getName())) {
                   if (isCategoryNode(cursor) && isCategoryNode(cursor.getLink().getLink())) {
                       LLNode temp = cursor.getLink().getLink().getLink();
                       cursor.setLink(null);
                       prev.setLink(temp);
                   }
                   else{
                       LLNode temp = cursor.getLink().getLink();
                       cursor.setLink(null);
                       cursor.setLink(temp);

                   }
               }
               prev=cursor;
               cursor=cursor.getLink();

           }
       } */
    //2 times
    public void removeName(String name) {
        if (head == null) {
            return;
        } else {
            LLNode previous = null;
            LLNode current = head;
            while (current != null) {
                if (current.getName().compareTo(name) == 0) {
                    LLNode next = current.getLink();
                    previous.setLink(next);
                    return;

                } else {
                    previous = current;
                    current = current.getLink();

                }
            }
        }
    }

    //head-normal-tail
    public void removeCategoryNode() {
        LLNode previous = null;
        LLNode current = head;
        LLNode next = head.getLink();
        while (next != null) {
            if (isCategoryNode(current) && isCategoryNode(next)) {
                if (previous == null) {
                    head = next;
                    return;
                } else {
                    LLNode nextOfNext = next;
                    previous.setLink(nextOfNext);
                    return;
                }
            } else if (isCategoryNode(current) && current.getLink() == null) {
                previous.setLink(null);
                return;
            } else {
                previous = current;
                current = next;
                next = next.getLink();
            }
        }
    }

    public void removeCategory(String letter) {
        if (head == null) {
            return;
        }
        if (head.getName().compareTo(letter)==0){
            LLNode next=head.getLink();
            while (next!=null){
                if (next.getName().substring(0,1).compareTo(letter)==0){
                    next=next.getLink();
                }
                else{
                    head=next;
                    return;
                }
            }
        }

        LLNode previous = head;
        LLNode current = head.getLink();
        while (current != null) {
            if (letter.compareTo(current.getName().substring(0, 1)) == 0) {
                LLNode nextOfNext = current.getLink();
                previous.setLink(nextOfNext);
                current = nextOfNext;
            } else {
                previous = current;
                current = current.getLink();
            }
        }
    }


    public boolean find(String name) {
        boolean foundName = false;
        LLNode currentNode = head;
        while (currentNode != null && foundName == false) {
            if ((currentNode.getName().equalsIgnoreCase(name))) {
                foundName = true;
                break;

            } else {
                currentNode = currentNode.getLink();
            }
        }
        return foundName;

    }

    public void printList() {
        LLNode currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getName());
            currentNode = currentNode.getLink();
        }
    }

    public void printAlternate() {
        LLNode currentNode = head;
        while (currentNode.getLink() != null) {
            System.out.println(currentNode.getName());
            currentNode = currentNode.getLink().getLink();
        }
    }


}

