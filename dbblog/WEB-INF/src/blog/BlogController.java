package blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 操作Blog的業務邏輯
 * 
 * @author Shinji Miyamoto
 */
public class BlogController {

    /**
     * Singleton的實體
     */
    private static BlogController controller = new BlogController();

    /**
     * 編號計數器
     */
    private int idCounter;

    /**
     * Blog清單
     */
    private List<Topic> topics = new ArrayList<Topic>();

    /**
     * 取得這個類別的實體
     * 
     * @return BlogController的實體
     */
    public static BlogController getInstance() {
        return controller;
    }

    private BlogController() {
    }

    /**
     * 登錄(post)文章
     * @param topic 文章
     */
    public void postTopic(Topic topic) {
        synchronized (this) {
            topic.setId(idCounter++);
            topic.setPostDate(new Date());//現在時間
            topics.add(topic);
        }
    }

    /**
     * 取得最近的(即全部的)文章
     * 
     * @return文章清單
     */
    public List<Topic> getTopics() {
        return new ArrayList<Topic>(topics);
    }

}