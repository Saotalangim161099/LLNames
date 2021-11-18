/*
public class LinkedList<T> {
    public LLNode<T> head;
    public LLNode<T> sorted;
    public LinkedList() {
        this.head = null;
    }

    public void addLast(T element) {
        LLNode<T> newNode=new LLNode<>(element);
        if (head==null) {
            head = newNode;
        }
        else{
            LLNode<T> currentNode=head;
            while (currentNode.getLink()!=null){
                currentNode=currentNode.getLink();
            }
            currentNode.setLink(newNode);
        }
    }

    public LLNode<T> removeLast() {
        if (head==null||head.getLink()==null){
            return null;
        }
        else{
            LLNode<T> currentNode=head;
            while (currentNode.getLink().getLink()!=null){
                currentNode=currentNode.getLink();
            }
            currentNode.setLink(null);
        }
        return head;
    }

    public void addFirst(T newNumber) {
        LLNode<T> newNode = new LLNode<T>(newNumber);
        if (head == null) {
            head = newNode;
        }
        newNode.setLink(head);
        head = newNode;
    }

    public void removeFirst() {
        LLNode<T> second=head.getLink();
        head.setLink(null);
        head=second;

    }

    public void swap(int startIndex) {
        LLNode<T> current = head;
        for (int i = 0; i < startIndex - 1; i++) {
            current = current.getLink();
        }
        T temp = current.getInfo();
        current.setInfo(current.getLink().getInfo());
        current.getLink().setInfo(temp);
    }

    public void swapNodes(T x, T y) {
        if (x == y) {
            return;
        } else {
            //determine the positions of previous x, current x, previous y, current y
            LLNode<T> prevX = null;
            LLNode<T> currX = head;
            while (currX != null && currX.getInfo() != x) {
                currX = currX.getLink();
            }
            LLNode<T> prevY = null;
            LLNode<T> currY = head;
            while (currY != null && currY.getInfo() != y) {
                currY = currY.getLink();
            }
            if (currX == null || currY == null) {
                return;
            }
            LLNode<T> temp1 = prevX.getLink();
            //prevY.getLink()= prevX.getLink();


            //swap currX.getLink() and currY.getLink()
            T temp2 = currY.getInfo();
            currY.setInfo(currX.getInfo());
            currX.setInfo(temp2);

        }
    }

    //public LLNode<T> reverseList(LLNode<T> head) {
        //return reverse(head, null);



    /*public void deleteFriends(){
        LLNode<T> prev=null;
        LLNode<T> curr=head;
        while (curr.getLink()!=null){
            prev=curr;
            curr=curr.getLink();
            if (prev.getInfo()>curr.getInfo()){

            }
        }
    }
    */

/*
    public void printList() {
        LLNode<T> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getInfo());
            currentNode = currentNode.getLink();
        }
    }
    /*public void sort(){
        //compare current data with index data
        //for each current value, index is the next to
        //current node which traverse from current's next node till null
        LLNode<T> current=head;
        LLNode<T> index=null;
        while (current!=null){
            index=current.getLink();
            while (index!=null){
                if (current.getInfo()>index.getInfo()){
                    temp=current.getInfo();
                    current.setInfo(index.getInfo());
                    index.setInfo(temp);
                }
                index=index.getLink();
            }
            current=current.getLink();
        }
    }
    public void insertionSort(LLNode<T> head){
        sorted=null;
        LLNode<T> current=head;
        while (current!=null){
            LLNode<T> next=current.getLink();
            sortedInsert(current);
            current=current.getLink();
        }
        head=sorted;

    }
    public LLNode<T> partitionLast(LLNode<T> start, LLNode<T> end){
        if (start==end||start==null||end==null){
            return start;
        }
        LLNode<T> pivot_prev=start;
        LLNode<T> current=start;
        T pivot=end.getInfo();
        while (start!=end){
            if (start.getInfo()<pivot){
                pivot_prev=current;
                T temp= current.getInfo();

            }
        }
    }*/
    //public void addAtInfo(T infoPrev, T addedNode){
        //LLNode<T> newNode=new LLNode<>(addedNode);
        //LLNode<T> current=head;
        //for (int i=0;i<infoPrev;i++){
            //current=current.getLink();
        //
        //newNode.setLink(current.getLink());
        //current.setLink(newNode);

    //
/*
    public void deleteAtInfo(T infoDeleted){

        LLNode<T> current=head;
        while (current!=null&&current.getLink().getInfo()!=infoDeleted){
            current=current.getLink();
        }
        LLNode<T> temp=current.getLink().getLink();
        current.getLink().setLink(null);
        current.setLink(temp);
    }
    public void printReverse(){

    }
}*/
