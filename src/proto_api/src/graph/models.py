from sqlalchemy import Table, Column, Integer, String, ForeignKey
from sqlalchemy.orm import relationship
from .base import Base

qa_bridge = Table('qa_bridge', Base.metadata,
    Column('question_id', Integer, ForeignKey('question.ID')),
    Column('answer_id', Integer, ForeignKey('answer.ID'))
)

class QuestionModel(Base):
    __tablename__ = 'question'
    ID = Column(Integer, primary_key=True)
    question = Column(String(256), index=True, unique=True)
    answers = relationship(
        "AnswerModel",
        secondary=qa_bridge,
        back_populates="questions")

class AnswerModel(Base):
    __tablename__ = 'answer'
    ID = Column(Integer, primary_key=True)
    answer = Column(String(256), index=True, unique=True)
    questions = relationship(
        "QuestionModel",
        secondary=qa_bridge,
        back_populates="answers")
