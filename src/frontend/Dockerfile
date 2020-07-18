FROM node:12
RUN mkdir /src
ADD /frontend/src /src
WORKDIR /src
RUN yarn global add expo-cli && yarn install
EXPOSE 19000
EXPOSE 19001
EXPOSE 19002