FROM node:18-alpine AS build
WORKDIR /app
COPY . .
RUN npm install && npm run build --prod

FROM nginx:alpine
COPY --from=build /app/dist/demo66/browser /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
