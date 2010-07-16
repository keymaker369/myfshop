package org.seke.fs;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 15, 2010
 * Time: 9:59:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class Order {

    private int id;
    private String commitDate;
    
    public Order() {
    }

    public Order(int id, String commitDate) {
        this.id = id;
        this.commitDate = commitDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(String commitDate) {
        this.commitDate = commitDate;
    }
}
