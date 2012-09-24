package net.foogoo.ratpack

import groovy.xml.MarkupBuilder
import javax.servlet.http.Cookie

class CookieDsl {

	String name, value, domain, path, comment
	int maxAge=-1, version
	boolean secure = false
	
	def static bake(closure) {
		
		CookieDsl cookieDsl = new CookieDsl()
		closure.delegate = cookieDsl
		closure()
		
		return createCookieFrom(cookieDsl)
	}
	
	private static def createCookieFrom(cookieDsl) {
		
		Cookie cookie = new Cookie(cookieDsl.name, cookieDsl.value)		

		if(cookieDsl.domain)
			cookie.domain = cookieDsl.domain

		if(cookieDsl.maxAge >= 0)
			cookie.maxAge = cookieDsl.maxAge

		cookie.path = cookieDsl.path
		cookie.comment = cookieDsl.comment
		cookie.version = cookieDsl.version
		cookie.secure = cookieDsl.secure
		
		return cookie
	}
	
	def name(String val) {
		this.name = val
	}
	
	def value(String val) {
		this.value = val
	}
	
	def domain(String val) {
		this.domain = val
	}
	
	def path(String val) {
		this.path = val
	}
	
	def comment(String val) {
		this.comment = val
	}
	
	def maxAge(int val) {
		this.maxAge = val
	}
	
	def version(int val) {
		this.version = val
	}
	
	def secure() {
		this.secure = true
	}
}
