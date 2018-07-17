package Model;

import java.sql.*;

/**
 *
 * @author HansTCS
 */
public class PollingBemModel {

    private int polling_id;
    private String option;
    private String poll_category;
    private int poll_amount;
    ConnectionDB conn;
    final String update = "UPDATE polling SET poll_amount=`poll_amount`+1 WHERE polling_id=? ;";


    public int getPolling_id() {
        return polling_id;
    }

    public void setPolling_id(int polling_id) {
        this.polling_id = polling_id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getPoll_category() {
        return poll_category;
    }

    public void setPoll_category(String poll_category) {
        this.poll_category = poll_category;
    }

    public int getPoll_amount() {
        return poll_amount;
    }

    public void setPoll_amount(int poll_amount) {
        this.poll_amount = poll_amount;
    }

    public PollingBemModel() {
        conn = new ConnectionDB();
    }

    public int updatePolling(int polling_id) {
        int rowUpdated = 0;

        try {
            Connection connect = ConnectionDB.ConnectDB();
            PreparedStatement ps = connect.prepareStatement(update);
            ps.setInt(1, polling_id);

            rowUpdated = ps.executeUpdate();

        } catch (SQLException ex) {

        }
        return rowUpdated;
    }
}
