FROM node:10-alpine as builder
COPY package.json package-lock.json ./
RUN npm ci && mkdir /ng-app && mv ./node_modules ./ng-app/
WORKDIR /ng-app
COPY . .
ARG NG_ENV=production
RUN npm run ng build -- --configuration=$NG_ENV

FROM nginx:alpine
COPY nginx/default.conf /etc/nginx/conf.d/
RUN rm -rf /usr/share/nginx/html/*
COPY --from=builder /ng-app/dist/angularapp /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]
