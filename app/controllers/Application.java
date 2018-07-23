package controllers;

import models.Candy;
import play.*;
import play.api.templates.Html;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
    private int age;

    public static Result showMain(Html content) {
        return ok(main.render(content));
    }

    public static Result index() {
        return showMain(home.render());
    }

    public static Result youpage(){
        return showMain(youpage.render());
    }


    public static Result test(){
        return showMain(test.render());
    }

    public static Result mypage() {
        return showMain(mypage.render());
    }

    public static Result showMyCandy(){
        Candy sg = new Candy();
        sg.setId("S001");
        sg.setName("ซูการ์ ลูกอมไทย");
        sg.setPrice(500.00);

        Candy h = new Candy("H009","ฮอลล์ เย็นแล้วเย็นอีก", 1500.00);

        return showMain(showMyCandy.render(sg, h));
    }

    public static Result inputCandy() {
        return showMain(inputCandy.render());
    }

    public static Result postCandy(){
        DynamicForm myForm = Form.form().bindFromRequest();
        //Candy candy = new Candy();
        String id, name;
        double price;
        if(myForm.hasErrors()){
            return showMain(inputCandy.render());
        }else {
            id = myForm.get("id");
            name = myForm.get("name");
            price= Double.parseDouble(myForm.get("price"));
            Candy candy = new Candy(id, name, price);
            /*candy.setId(id);
            candy.setName(name);
            candy.setPrice(price); */
            return showMain(showOutputCandy.render(candy));
        }
    }
}
