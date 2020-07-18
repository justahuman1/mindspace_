import React, { Component } from 'react';
import {StyleSheet, Text, View, Image} from 'react-native';

import SwipeCards from 'react-native-swipe-cards';

class Card extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <View style={[styles.card, {backgroundColor: this.props.backgroundColor}]}>
        <Text>{this.props.text}</Text>
      </View>
    )
  }
}

class NoMoreCards extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <View>
        <Text style={styles.noMoreCardsText}>All Questions Complete!</Text>
      </View>
    )
  }
}

export default class extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      cards: [
        {text: 'Question 1', backgroundColor: 'rgb(171, 227, 236)'},
        {text: 'Question 2', backgroundColor: 'purple'},
        {text: 'Question 3', backgroundColor: 'green'},
        {text: 'Question 4', backgroundColor: 'blue'},
        {text: 'Question 5', backgroundColor: 'cyan'},
        {text: 'Question 6', backgroundColor: 'orange'},
      ]
    };
  }

  handleRight (card) {
    console.log(`Right for ${card.text}`)
  }
  handleLeft (card) {
    console.log(`Left for ${card.text}`)
  }
  handleUp (card) {
    console.log(`Up for ${card.text}`)
  }
  render() {
    // If you want a stack of cards instead of one-per-one view, activate stack mode
    // stack={true}
    return (
      <SwipeCards
        cards={this.state.cards}
        renderCard={(cardData) => <Card {...cardData} />}
        renderNoMoreCards={() => <NoMoreCards />}

        handleYup={this.handleRight}
        handleNope={this.handleLeft}
        handleMaybe={this.handleUp}
        hasMaybeAction
      />
    )
  }
}

const styles = StyleSheet.create({
  card: {
    justifyContent: 'center',
    alignItems: 'center',
    width: "40vh",
    height: "40vh",
    borderRadius: '6%'
  },
  noMoreCardsText: {
    fontSize: 22,
  }
});