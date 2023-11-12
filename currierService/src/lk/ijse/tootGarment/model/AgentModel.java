package lk.ijse.tootGarment.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.tootGarment.to.Agent;
import lk.ijse.tootGarment.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AgentModel {
    public static boolean add(Agent agent) throws SQLException, ClassNotFoundException {
        boolean i =CrudUtil.execute("INSERT INTO agent VALUES(?,?,?,?,?)",
                agent.getAgent_nic(),
                agent.getName(),
                agent.getCompany_name(),
                agent.getEmail(),
                agent.getContacNo()
        );
        System.out.println(i);
        return i;
    }

    public static Agent search(String searchNic) throws SQLException, ClassNotFoundException {
         ResultSet rst =CrudUtil.execute("SELECT * FROM agent WHERE agent_Nic='"+searchNic+"'");
        System.out.println(rst);
         if (rst.next()){
             return new Agent(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
         }
        return null;
    }

    public static boolean update(Agent agent) throws SQLException, ClassNotFoundException {
        boolean i =CrudUtil.execute("UPDATE agent set name=?, company_name=?, email=?, contacNo=? where agent_Nic=?",
                agent.getName(),
                agent.getCompany_name(),
                agent.getEmail(),
                agent.getContacNo(),
                agent.getAgent_nic()
        );
        System.out.println(i);
        return i;
    }

    public static boolean delete(String agentNic) throws SQLException, ClassNotFoundException {
        boolean i=CrudUtil.execute("DELETE FROM agent WHERE agent_Nic='"+agentNic+"'");
        System.out.println(i);
        return i;
    }

    public static ArrayList View() throws SQLException, ClassNotFoundException {
        ArrayList<Agent> agentView=new ArrayList<>();
        ResultSet rst=CrudUtil.execute("SELECT * FROM agent");


        while(rst.next()){
            agentView.add(
                    new Agent(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5))
            );

        }
        return agentView;
    }
}
