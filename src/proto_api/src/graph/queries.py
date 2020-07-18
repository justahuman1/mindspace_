from graphene_sqlalchemy import SQLAlchemyConnectionField
from .schemas import Question, Answer
import graphene

## Test [Passed]
# {
#   allQuestions {
#     edges {
#       node {
#         question
#         answers {
#           edges {
#             node {
#               answer
#             }
#           }
#         }
#       }
#     }
#   }
# }

# Query Object
class Query(graphene.ObjectType):
    node = graphene.relay.Node.Field()
    # question = graphene.relay.Node.Field(Question)
    all_questions = SQLAlchemyConnectionField(Question)
    # answer = graphene.relay.Node.Field(Answer)
    all_answers = SQLAlchemyConnectionField(Answer)


schema = graphene.Schema(query=Query)
