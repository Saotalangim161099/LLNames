public class LLNode<String> {
    protected String info;
    protected LLNode<String> link;
    protected boolean isLetterNode;

    public LLNode(String info,LLNode link, boolean isLetterNode) {
        this.info = info;
        this.link = link;
        this.isLetterNode=isLetterNode;
    }

    public boolean isLetterNode() {
        return isLetterNode;
    }

    public void setLetterNode(boolean letterNode) {
        isLetterNode = letterNode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public LLNode<String> getLink() {
        return link;
    }

    public void setLink(LLNode<String> link) {
        this.link = link;
    }
}
