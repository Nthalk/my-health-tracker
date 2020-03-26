My Health Tracker
========

This is a starter project for using spring-boot, postgres, jooq, jooq-models, spring-webmvc, generated api models, react, and typescript.
   
## Developing

    # Ensure clean build
    mvn clean install
    
    # Dev Tools:
    ./db-migrate            # <= Run this when you update migrations
    ./regen                 # <= Run this when you want to regen models (db/api)
    ./regen-db-models       # <= Run this when you want to regen database models
    ./regen-api-models      # <= Run this when you want to regen api models
    ./dev-watch             # <= Watch for changes and rebuild web ui (see http://localhost:8081 for live view)
    
    # Server Tools:
    ./webcli                # <= Run the webserver
    ./webcli --help         # <= Print webcli help
    
## How to work

Most of the work will be done writing/reading migrations, building api controllers, and ui.

Migrations are located within `db/src/main/resources/db`.

Api controllers are located in `web/src/main/java/com/nthalk/healthtracker/web/api`. When you make 
changes here, you should run `./regen-api-models` to make sure the client has the latest code. If 
you are introducing a new api, you may need to modify the `Api` class in the `ApiProvider.tsx` file.

The ui is a React app that is built during the compile phase of maven, however you can run the 
spring boot server separately, and then use './dev-watch' to spin up a server on 
`http://localhost:8081` that will proxy api requests to `http://localhost:8080` while providing a 
hot reloading api as well as development code and sourcemaps.


# Committing

When committing code, be sure to run `./lint`.
   
## Todo

- [ ] Allow migrate to work without clean/compile
- [ ] Drop views before migrate, and re-create them after migrate
- [ ] Fully implement the oauth/auth0 flow
- [ ] Git hook to auto-run `./lint` on committed files only
- [ ] Write more todo's

