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
                if(encoutneredCateogryNode == false) {
                    encoutneredCateogryNode = isCategoryNodeForName(cursor, node.getName());
                }
                if (next == null) {
                    if (encoutneredCateogryNode) {
                        System.out.println("Creating Name Node");
                        node.setLink(next);
                        cursor.setLink(node);
                    } else {
                        System.out.println("Creating Category Node and Name Node");
                        LLNode categoryNode = new LLNode(node.getName().charAt(0) + "", null);
                        categoryNode.setLink(node);
                        cursor.setLink(categoryNode);
                        node.setLink(next);
                    }
                    return;
                } else if (node.aheadOfNode(next)) {
                    if (encoutneredCateogryNode) {
                        System.out.println("Creating Name Node 2");
                        node.setLink(next);
                        cursor.setLink(node);
                    } else {
                        System.out.println("Creating Category Node and Name Node 2");
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
        System.out.println("Checking Node " + node.getName() + " - " + name + " - " + test);
        return test;
    }


    public void add(String name) {
        LLNode newNode = new LLNode(name, null);
        addNode(newNode);
    }
    public void removeName(String name)
    {

    }

    public void removeCategory(char category)
    {

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

