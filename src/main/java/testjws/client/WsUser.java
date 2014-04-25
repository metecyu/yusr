
package testjws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for wsUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="birthday" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="duty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dutydetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fjh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fphone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iseffect" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sfzid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workstate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsUser", propOrder = {
    "birthday",
    "duty",
    "dutydetails",
    "fjh",
    "fphone",
    "id",
    "iseffect",
    "loginid",
    "mobile",
    "orgtype",
    "password",
    "sfzid",
    "username",
    "workstate"
})
public class WsUser {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar birthday;
    protected String duty;
    protected String dutydetails;
    protected String fjh;
    protected String fphone;
    protected String id;
    protected String iseffect;
    protected String loginid;
    protected String mobile;
    protected String orgtype;
    protected String password;
    protected String sfzid;
    protected String username;
    protected String workstate;

    /**
     * Gets the value of the birthday property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthday() {
        return birthday;
    }

    /**
     * Sets the value of the birthday property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthday(XMLGregorianCalendar value) {
        this.birthday = value;
    }

    /**
     * Gets the value of the duty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuty() {
        return duty;
    }

    /**
     * Sets the value of the duty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuty(String value) {
        this.duty = value;
    }

    /**
     * Gets the value of the dutydetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDutydetails() {
        return dutydetails;
    }

    /**
     * Sets the value of the dutydetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDutydetails(String value) {
        this.dutydetails = value;
    }

    /**
     * Gets the value of the fjh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFjh() {
        return fjh;
    }

    /**
     * Sets the value of the fjh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFjh(String value) {
        this.fjh = value;
    }

    /**
     * Gets the value of the fphone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFphone() {
        return fphone;
    }

    /**
     * Sets the value of the fphone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFphone(String value) {
        this.fphone = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the iseffect property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIseffect() {
        return iseffect;
    }

    /**
     * Sets the value of the iseffect property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIseffect(String value) {
        this.iseffect = value;
    }

    /**
     * Gets the value of the loginid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginid() {
        return loginid;
    }

    /**
     * Sets the value of the loginid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginid(String value) {
        this.loginid = value;
    }

    /**
     * Gets the value of the mobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobile(String value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the orgtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgtype() {
        return orgtype;
    }

    /**
     * Sets the value of the orgtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgtype(String value) {
        this.orgtype = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the sfzid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSfzid() {
        return sfzid;
    }

    /**
     * Sets the value of the sfzid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSfzid(String value) {
        this.sfzid = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the workstate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkstate() {
        return workstate;
    }

    /**
     * Sets the value of the workstate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkstate(String value) {
        this.workstate = value;
    }

}
