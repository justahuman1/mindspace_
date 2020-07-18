### Create All tables
curl http://0.0.0.0:5000/createtables

### Create a question
curl -X POST \
    -H "Content-Type: application/json" \
    -d '{"question" : "how are you today?", "answers":["Good","Great","Meh"]}' \
     http://0.0.0.0:5000/makequestion

# Create a question 2
curl -X POST \
    -H "Content-Type: application/json" \
    -d '{"question" : "How tired are you?", "answers":["Barely","Medium","Lots"]}' \
     http://0.0.0.0:5000/makequestion


### Add a new answers
curl -X POST \
    -H "Content-Type: application/json" \
    -d '{"answer" : "Amazing", "questions":["How tired are you?","how are you today?"]}' \
     http://0.0.0.0:5000/makeanswer

curl -X POST \
    -H "Content-Type: application/json" \
    -d '{"answer" : "Tired", "questions":["How tired are you?"]}' \
     http://0.0.0.0:5000/makeanswer

curl -X POST \
    -H "Content-Type: application/json" \
    -d '{"answer" : "Content", "questions":"How tired are you?"}' \
     http://0.0.0.0:5000/makeanswer
