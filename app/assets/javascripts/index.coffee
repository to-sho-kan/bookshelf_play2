console.log 'to-sho-kan application.'

app = new Vue
	el: "#container"
	data:
	  main: undefined

Vue.component "home", 
	template: "#home"

Vue.component "example",
	template: "#example"

Vue.component "login",
	template: "#login"

page '/', (ctx) ->
	app.main = "home"

page '/example/:q', (ctx) ->
	app.main = "example"

page '/login', (ctx) ->
	app.main = "login"

page()
