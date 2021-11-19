public class LinkedListClass {
    public LLNode head;

    public LinkedListClass() {
        head = null;
    }

    public void addNode(LLNode node) {
        if (head == null) {
            //Add letter category Node, set link
            LLNode categoryNode = new LLNode(node.getName().charAt(0) + "", null);
            categoryNode.setLink(node);
            head = categoryNode;
        } else {
            //iterate the linked list to find when comparisionTo resulting in == -1
            LLNode cursor = head;
            if (node.aheadOfNode(cursor)) {
                LLNode categoryNode = new LLNode(node.getName().charAt(0) + "", null);
                categoryNode.setLink(node);
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

                        node.setLink(next);
                        cursor.setLink(node);
                    } else {

                        LLNode categoryNode = new LLNode(node.getName().charAt(0) + "", null);
                        categoryNode.setLink(node);
                        cursor.setLink(categoryNode);
                        node.setLink(next);
                    }
                    return;
                } else if (node.aheadOfNode(next)) {
                    if (encoutneredCateogryNode) {

                        node.setLink(next);
                        cursor.setLink(node);
                    } else {

                        LLNode categoryNode = new LLNode(node.getName().charAt(0) + "", null);
                        categoryNode.setLink(node);
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
        boolean test = node.getName().length() == 1 && node.getName().toLowerCase().charAt(0) == name.toLowerCase().charAt(0);

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
        LLNode prevOfPrev = null;
        LLNode previous = head;
        LLNode current = head.getLink();
        while (current != null) {
            if (isCategoryNode(previous) && isCategoryNode(current)) {
                if (prevOfPrev == null) {
                    head = current;
                    return;
                } else {
                    prevOfPrev.setLink(current);
                    return;
                }
            } else if (isCategoryNode(current) && isCategoryNode(current.getLink())) {
                previous.setLink(null);
                return;
            } else {
                prevOfPrev = previous;
                previous = current;
                current = current.getLink();
            }
        }
    }

    public void removeCategory(char category) {

    }

    public boolean find(String name) {
        boolean foundName = false;
        LLNode currentNode = new LLNode(name, null);
        while (currentNode != null && !foundName) {
            if ((currentNode.getName().compareTo(name)) == 0) {
                foundName = true;
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


}

