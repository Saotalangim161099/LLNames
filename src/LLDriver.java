public class LLDriver {
    public static void main(String[] args) {
        LinkedListClass llC = new LinkedListClass();
        System.out.println("Adding names");
        llC.add("Anna");
        llC.printList();
        System.out.println("____________________________________");
        llC.add("Cella");
        llC.printList();
        System.out.println("____________________________________");
        llC.add("Abe");
        llC.printList();
        System.out.println("____________________________________");
        llC.add("Christian");
        llC.add("Dave");
        llC.add("Tavideeee");
        llC.add("Arthur");
        llC.add("Becca");
        llC.add("Anna");
        llC.printList();
        //Abe --> Anna
//        LLNode node = new LLNode("Anna", null);
//        LLNode next = new LLNode("Abe", null);
//        System.out.println(node.aheadOfNode(next));
    }

}
