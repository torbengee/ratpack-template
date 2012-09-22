package net.foogoo.ratpack

import com.bleedingwolf.ratpack.RatpackRequestDelegate

public class MyDelegateWithCookies extends RatpackRequestDelegate {

   void addCookie(cookieDsl) {
        def cookie = CookieDsl.bake(cookieDsl)
        response.addCookie(cookie)
   }
   
}