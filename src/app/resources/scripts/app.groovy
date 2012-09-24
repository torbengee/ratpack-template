delegate 'net.foogoo.ratpack.MyDelegateWithCookies'

get('/') {
   render('index.html')
}

get('/person/:name') {

    addCookie {
        name 'last-person-viewed'
        value urlparams.name
	maxAge 60
    }
      
    render('person.html', [name : urlparams.name])
}
