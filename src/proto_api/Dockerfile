FROM python:3.8
ENV PYTHONUNBUFFERED 1
ADD /backend/src /src
WORKDIR /src
RUN pip install -r requirements.txt
ARG FLASK_APP
ENV FLASK_APP ./app.py
EXPOSE 5000
