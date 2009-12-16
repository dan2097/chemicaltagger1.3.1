package uk.ac.cam.ch.wwmm.chemicaltagger.extractText;

public class DocumentContainer {

    private String Id = "";
    private String Title = "";
    private String TaggedTitle = "";
    private String Content = "";
    private String TaggedContent = "";
    private String NMR = "";

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNMR() {
        return NMR;
    }

    public void setNMR(String NMR) {
        this.NMR = NMR;
    }

    public String getTaggedContent() {
        return TaggedContent;
    }

    public void setTaggedContent(String TaggedContent) {
        this.TaggedContent = TaggedContent;
    }

    public String getTaggedTitle() {
        return TaggedTitle;
    }

    public void setTaggedTitle(String TaggedTitle) {
        this.TaggedTitle = TaggedTitle;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
}