'use strict';

import React from 'react';
import MaterialColors from 'materialcolorize'

export default class ColorPicker extends React.Component {

  /*
   * State variables:
   * value - String representation of input color
   * materialValue - String representation of closest Material color
   */
  
  constructor(props){
    super(props);
    this.state = {
      value: props.default,
      materialValue: MaterialColors.approximateColor(props.default)
    };
  }

  handleChange(event){
    var isColor = /(^[0-9A-F]{6}$)/i.test(event.target.value);
    if(isColor){
      this.setState({
        value: event.target.value,
        materialValue: MaterialColors.approximateColor(event.target.value)
      });
    }
    else {
      this.setState({
        value: null,
        materialValue: null
      });
    }
  }

  get dynamics() {
    let color = this.state.value || 'ffffff';
    return {
      backgroundColor: '#' + color
    };
  }

  get materialDynamics(){
    let color = this.state.materialValue || 'ffffff';
    return {
      backgroundColor: '#' + color
    }
  }

  render(){
    let { value } = this.state;
    return (
      <div>
        <input type="text" 
          onChange={this.handleChange.bind(this)} 
          defaultValue={value} />
        <h4 style={this.dynamics}> Input: {this.state.value} </h4>
        <h4 style={this.materialDynamics}> Output: {this.state.materialValue} </h4>
      </div>
    );
  }

  static PropTypes = {
    default: React.PropTypes.string
  }
  static defaultProps = {
    default: 'fafafa'
  }
}