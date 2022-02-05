package pers.howard.personalspace.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 评论模型
 */
public class RemarkItem {
    private String name;
    private String detail;
    private Date sendDate;

    protected String[] monthName = {
            "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec"
    };

    public String defaultDateFormat() {
        if (sendDate == null)
            return "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sendDate);
        final int month = calendar.get(Calendar.MONTH);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" dd, yyyy");
        return monthName[month] + simpleDateFormat.format(sendDate);
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
