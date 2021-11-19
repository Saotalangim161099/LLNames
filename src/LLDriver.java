public class LLDriver {
    public static void main(String[] args) {
        LinkedListClass llC = new LinkedListClass();

        llC.add("Anna");
        //      llC.printList();
//       System.out.println("____________________________________");
        llC.add("Cella");
        //       llC.printList();
//       System.out.println("____________________________________");
        llC.add("Abe");
        //      llC.printList();
//        System.out.println("____________________________________");
        llC.add("Christian");
        llC.add("Dave");
        llC.add("Tavideeee");
        llC.add("Arthur");
        llC.add("Becca");
        System.out.println("___________________");
        llC.printList();//     System.out.println("Removing Dave");//     llC.removeName("Dave");
    //    llC.printList();
    //    System.out.println("After removing the name node. Now remove the category node: ");
    //     llC.removeCategoryNode();
    //    System.out.println("After reversing: ");
    //    llC.reverseList();
        //    llC.printList();
        //Abe --> Anna
    //        LLNode node = new LLNode("Anna", null);
    //        LLNode next = new LLNode("Abe", null);
    //        System.out.println(node.aheadOfNode(next));
        // System.out.println("Printing alternate nodes: ");
        System.out.println("Deleting the letter A nodes: ");
        llC.removeCategory("A");

        llC.printList();

    }

}
