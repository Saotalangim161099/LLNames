public class LinkedListClass {
    public LLNode<String> head;

    public LinkedListClass() {
        head = null;
    }

    ;
/*
    //lack case Node<head
    public void addNames(String name) {
        LLNode<String> temp = new LLNode<>(name);
        LLNode<String> current = head;
        LLNode<String> back = null;
        boolean found = false;
        if (head == null) {
            head = temp;
        } else {
            while (current != null && !found) {
                if (((temp.getInfo()).compareTo(current.getInfo())) < 0) {
                    back.setLink(temp);
                    found = true;
                } else {
                    back = current;
                    current = current.getLink();
                }
            }
            LLNode<String> tempNode = current;
            if (found) {
                LLNode<String> letterNode = new LLNode<>(String.valueOf(name.charAt(0)));
                back.setLink(letterNode);
                letterNode.setLink(temp);
                temp.setLink(tempNode);
            } else {
                back.setLink(temp);
                temp.setLink(tempNode);
            }
        }
    }*/

    public void addNode(LLNode<String> node) {
        if (head == null) {
            head = node;
            return;
        } else {//head is not null
            if ((node.getName().compareTo(head.getName())) < 0) {   //node<head
                node.setLink(head);
                head = node;
            } else {   //node>head
                LLNode<String> currNode = head.getLink();
                LLNode<String> prevNode = head;
                while (currNode != null) {
                    if ((node.getName().compareTo(currNode.getName())) < 0) {  //node<currNode
                        LLNode<String> tempNode = currNode;
                        prevNode.setLink(node);
                        node.setLink(tempNode);
                    } else { //node>=currNode
                        prevNode = currNode;
                        currNode = currNode.getLink();
                    }
                }
                prevNode.setLink(node);

            }
        }

    }

    public boolean checkForLetter(String str) { //not meaning isLetter or not, but finding the section for the current node
        if (head == null) {
            return false;
        } else {
            boolean letterPresent = false;
            LLNode<String> currNode = head;
            while (currNode != null && !letterPresent) {
                if ((currNode.isLetterNode()) && str.compareTo(currNode.getName()) == 0) {
                    letterPresent = true;
                } else {
                    currNode = currNode.getLink();
                }
            }
            return letterPresent;

        }
    }

    public void add(String name) {
        LLNode<String> newNode = new LLNode<>(name, null, false);
        if (checkForLetter(name.substring(0,1))) { //successfully find the section for the node
            addNode(newNode);
        } else { //not available section for the node
            LLNode<String> newCharNode = new LLNode<>(name.substring(0, 1), null, true);
            addNode(newCharNode);
            addNode(newNode);
        }
    }

    public boolean find(String name) {
        boolean foundName = false;
        LLNode<String> currentNode = new LLNode<>(name, null, false);
        while (currentNode != null && !foundName) {
            if ((currentNode.getName().compareTo(name)) == 0) {
                foundName = true;
            } else {
                currentNode = currentNode.getLink();
            }
        }
        return foundName;

    }
    public void showNames(){
        LLNode currentNode=head;
        while (currentNode!=null){
            if (currentNode.isLetterNode){
                System.out.println(currentNode.getName());
            }
            else{
                System.out.println(" "+currentNode.getName());
            }
            currentNode=currentNode.getLink();
        }
    }





    public void printList() {
        LLNode<String> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getName());
            currentNode = currentNode.getLink();
        }
    }


}

