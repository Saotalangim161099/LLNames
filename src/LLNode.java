public class LLNode{

    //Attributes
    protected String name;
    protected LLNode link;

    //Constructor
    public LLNode(String name, LLNode link) {
        this.name = name;
        this.link = link;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LLNode getLink() {
        return link;
    }

    public void setLink(LLNode link) {
        this.link = link;
    }
    public boolean aheadOfNode(LLNode next)
    {
       return this.getName().compareTo(next.getName()) < 0;
    }
}
