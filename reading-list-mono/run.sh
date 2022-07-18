#!/bin/zsh

mvn spring-boot:run &&
npm run dev --prefix src/frontend & open http://localhost:8080
