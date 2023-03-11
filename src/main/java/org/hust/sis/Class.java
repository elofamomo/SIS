package org.hust.sis;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Class {
   private String classCode;
   private String classSubject;
//   private Map<>

   public Class(String classCode , String classSubject) {
       this.classCode = classCode;
       this.classSubject = classSubject;

   }

   public String getClassCode() {
       return classCode;
   }
   public String getClassSubject() {
       return classSubject;
   }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }
    public void setClassSubject(String classSubject) {
        this.classSubject = classSubject;
    }
}
