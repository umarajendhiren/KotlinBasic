package com.androidapps.basic.kotlinbasics;

public class DelegationJavaCode {

    interface Base {
        String getName();

        String  getMailId();

    }

    static class BaseImpl implements Base {
        String name, mail;

        public BaseImpl(String Name, String Mail) {
            this.name = Name;
            this.mail = Mail;
        }

        @Override
        public String getName() {
          return name;
        }

        @Override
        public String getMailId() {

            return mail;
        }
    }

    static class derived implements Base{
        Base base;
      public derived(Base base){

          this.base=base;
      }
        @Override
        public String getName() {
            return base.getName();
        }

        @Override
        public String getMailId() {
            return base.getMailId();
        }
    }


    public static void main(String[] args) {

        BaseImpl b=new BaseImpl("uma","umamail");

       derived d= new derived(b);
       System.out.println(d.getName());
       System.out.println(d.getMailId());
    }
}
