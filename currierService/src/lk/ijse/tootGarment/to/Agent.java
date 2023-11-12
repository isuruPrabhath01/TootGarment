package lk.ijse.tootGarment.to;

public class Agent {
    private  String agent_nic;
    private  String name;
    private  String company_name;
    private  String email;
    private  String contacNo;

    public Agent(){

    }

    public Agent(String agent_nic,String name, String company_name, String email, String contacNo){
        this.setAgent_nic(agent_nic);
        this.setName(name);
        this.setCompany_name(company_name);
        this.setEmail(email);
        this.setContacNo(contacNo);
    }


    public String getAgent_nic() {
        return agent_nic;
    }

    public void setAgent_nic(String agent_nic) {
        this.agent_nic = agent_nic;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacNo() {
        return contacNo;
    }

    public void setContacNo(String contacNo) {
        this.contacNo = contacNo;
    }
}
