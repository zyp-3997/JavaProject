package manage.bean;


import java.util.Date;

public class College {
   /**
    * ѧУ��ʶ��
    */
   private int id;
   /**
    * ѧУ����
    */
   private String name;
   /**
    * У��
    */
   private String president;
   /**
    * ��Уʱ��
    */
   private Date startTime;
   /**
    * ��ϵ�绰
    */
   private String telephone;
   /**
    * ��������
    */
   private String email;
   /**
    * ͨ�ŵ�ַ
    */
   private String address;
   /**
    * ѧУ���
    */
   private String profile;

   public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public String getPresident() {
       return president;
   }

   public void setPresident(String president) {
       this.president = president;
   }

   public Date getStartTime() {
       return startTime;
   }

   public void setStartTime(Date startTime) {
       this.startTime = startTime;
   }

   public String getTelephone() {
       return telephone;
   }

   public void setTelephone(String telephone) {
       this.telephone = telephone;
   }

   public String getEmail() {
       return email;
   }

   public void setEmail(String email) {
       this.email = email;
   }

   public String getAddress() {
       return address;
   }

   public void setAddress(String address) {
       this.address = address;
   }

   public String getProfile() {
       return profile;
   }

   public void setProfile(String profile) {
       this.profile = profile;
   }

   @Override
   public String toString() {
       return "College{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", president='" + president + '\'' +
               ", startTime=" + startTime +
               ", telephone='" + telephone + '\'' +
               ", email='" + email + '\'' +
               ", address='" + address + '\'' +
               ", profile='" + profile + '\'' +
               '}';
   }
}

