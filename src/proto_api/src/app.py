from flask import Flask, request 
from flask_graphql import GraphQLView
from graph import base, queries
from graph.models import (
    QuestionModel, AnswerModel)
import json

#/  CLI INIT
#/*     export FLASK_APP=app.py
#/*     flask run
#/  Optional local run:   flask run --host=0.0.0.0

app = Flask(__name__)
db = base.db_session 

# Routes
app.add_url_rule(
    '/graphql',
    view_func=GraphQLView.as_view(
        'graphql',
        schema=queries.schema,
        graphiql=True 
    )
)

@app.route('/')
def index():
    return '''Hello Mindspace World!'''


@app.route('/createtables')
def createTable():
    base.Base.metadata.create_all(base.engine)
    return "success"


@app.route('/makequestion', methods = ['POST'])
def make_question():
    # TODO: Add termination catches via data validation 
    data = request.get_json()
    # TODO check if ques is an instance of a list or a string --> Implement reflective resolver
    Ques = QuestionModel(question=data["question"])
    # TODO: Add ID functionality as well (check type for scalar int vs string vs list)
    answers = data['answers']
    
    if isinstance(answers, list):
        for ans in answers:
            Ans = AnswerModel(answer=ans)
            Ques.answers.append(Ans)
    elif isinstance(amswers, str):
        Ans = AnswerModel(answer=answers)
        Ques.answers.append(Ans)

    db.add(Ques)
    db.commit()
    return "made question successfully"


@app.route('/makeanswer', methods = ['POST'])
def add_answer():
    # TODO: Add termination catches via data validation 
    data = request.get_json()
    # TODO check if ans is an instance of a list or a string --> Implement reflective resolver
    Ans = AnswerModel(answer=data['answer'])
    # TODO: Add ID functionality as well (check type for scalar int vs string vs list)
    questions = data['questions']
    if isinstance(questions, list):
        Questions = QuestionModel.query.filter(QuestionModel.question.in_(data['questions'])).all()
        for Ques in Questions:
            Ques.answers.append(Ans)
            db.add(Ques)
    elif isinstance(questions, str):
        Question = QuestionModel.query.filter(QuestionModel.question == questions).first()
        Question.answers.append(Ans)

    db.commit()
    return "Made answers for questions."



@app.teardown_appcontext
def shutdown_session(exception=None):
    base.db_session.remove()

if __name__ == '__main__':
    app.run(debug=True, threaded=True)
