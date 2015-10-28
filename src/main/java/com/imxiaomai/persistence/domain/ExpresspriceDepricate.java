package com.imxiaomai.persistence.domain;

import com.imxiaomai.base.BaseDO;

public class ExpresspriceDepricate extends BaseDO{
    private Integer id;

    private String expressname;

    private Integer exampleweight;

    private Integer exampleprice;

    private String execscript;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpressname() {
        return expressname;
    }

    public void setExpressname(String expressname) {
        this.expressname = expressname == null ? null : expressname.trim();
    }

    public Integer getExampleweight() {
        return exampleweight;
    }

    public void setExampleweight(Integer exampleweight) {
        this.exampleweight = exampleweight;
    }

    public Integer getExampleprice() {
        return exampleprice;
    }

    public void setExampleprice(Integer exampleprice) {
        this.exampleprice = exampleprice;
    }

    public String getExecscript() {
        return execscript;
    }

    public void setExecscript(String execscript) {
        this.execscript = execscript == null ? null : execscript.trim();
    }
}