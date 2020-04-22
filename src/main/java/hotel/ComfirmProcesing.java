package hotel;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="ComfirmProcesing_table")
public class ComfirmProcesing {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone;
    private String date;
    private String userId;
    private Long regId;

    // 오류 시 삭제 delete
    public String getIflag() {
        return iflag;
    }

    public void setIflag(String iflag) {
        this.iflag = iflag;
    }

    private String iflag;
    //

    @PostPersist
    public void onPostPersist(){
        ReservationComfirmed reservationComfirmed = new ReservationComfirmed();
        BeanUtils.copyProperties(this, reservationComfirmed);
        reservationComfirmed.publish();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public Long getRegId() {
        return regId;
    }

    public void setRegId(Long regId) {
        this.regId = regId;
    }


}
