from graphene_sqlalchemy import SQLAlchemyObjectType
from .models import QuestionModel, AnswerModel
import graphene

class AnswerAttribute:
    answer = graphene.String(description="Answer Text")
    ID = graphene.ID(description="Global ID of the answer.")


class Answer(SQLAlchemyObjectType, AnswerAttribute):
   class Meta:
       model = AnswerModel
       interfaces = (graphene.relay.Node, )

# =========================================

class QuestionAttribute:
    question = graphene.String(description="Question Text")
    ID = graphene.ID(description="Global ID of the question.")

class Question(SQLAlchemyObjectType, QuestionAttribute):
    """Question node"""
    class Meta:
        model = QuestionModel
        interfaces = (graphene.relay.Node, )

