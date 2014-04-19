/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kodcu;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author hakdogan
 */

@ManagedBean
@RequestScoped
public class MyBean {
    
    private String ad;
    private String soyad;
    private String eposta;
    private String kkNumara;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getKkNumara() {
        return kkNumara;
    }

    public void setKkNumara(String kkNumara) {
        this.kkNumara = kkNumara;
    }
}
