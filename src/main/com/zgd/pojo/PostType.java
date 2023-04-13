package main.com.zgd.pojo;

public class PostType {
    private int postTypeId; //帖子内容id
    private String postType; //帖子内容类型

    public PostType(int postTypeId, String postType) {
        this.postTypeId = postTypeId;
        this.postType = postType;
    }

    public PostType() {
    }

    public int getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(int postTypeId) {
        this.postTypeId = postTypeId;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    @Override
    public String toString() {
        return "PostType{" +
                "postTypeId=" + postTypeId +
                ", postType='" + postType + '\'' +
                '}';
    }
}
