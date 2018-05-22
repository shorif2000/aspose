/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UddinS2
 */
@XmlRootElement
public class Flow {
    String src, dst;

    Flow(String src, String dst) {
        this.src = src;
        this.dst = dst;
    }
    
    
    public String getSrc(){
        return src;
    }
    
    @XmlElement
    public void setSrc(String text) {
        this.src = text;
    }
    
    public String getDst(){
        return dst;
    }
    
    @XmlElement
    public void setDst(String text) {
        this.dst = text;
    }
}
