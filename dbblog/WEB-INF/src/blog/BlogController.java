package blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * �ާ@Blog���~���޿�
 * 
 * @author Shinji Miyamoto
 */
public class BlogController {

    /**
     * Singleton������
     */
    private static BlogController controller = new BlogController();

    /**
     * �s���p�ƾ�
     */
    private int idCounter;

    /**
     * Blog�M��
     */
    private List<Topic> topics = new ArrayList<Topic>();

    /**
     * ���o�o�����O������
     * 
     * @return BlogController������
     */
    public static BlogController getInstance() {
        return controller;
    }

    private BlogController() {
    }

    /**
     * �n��(post)�峹
     * @param topic �峹
     */
    public void postTopic(Topic topic) {
        synchronized (this) {
            topic.setId(idCounter++);
            topic.setPostDate(new Date());//�{�b�ɶ�
            topics.add(topic);
        }
    }

    /**
     * ���o�̪�(�Y������)�峹
     * 
     * @return�峹�M��
     */
    public List<Topic> getTopics() {
        return new ArrayList<Topic>(topics);
    }

}