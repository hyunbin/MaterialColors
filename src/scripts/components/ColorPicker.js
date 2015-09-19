'use strict';

import React from 'react';
import mc from 'materialcolorize'

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
      materialValue: mc.approximateColor(props.default),
      materialColorFamily: mc.getColorFamily(props.default)
    };
  }

  handleChange(event){
    var isColor = /(^[0-9A-F]{6}$)/i.test(event.target.value);
    if(isColor){
      this.setState({
        value: event.target.value,
        materialValue: mc.approximateColor(event.target.value)
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
        <div className="row">
          <div className="col m4">
            <label htmlFor="inputHex">Input</label>
            <input type="text" id="inputHex"
              onChange={this.handleChange.bind(this)}
              defaultValue={value} />
          </div>
          <div className="col m4">
            <h4> Output: #{this.state.materialValue} </h4>
          </div>
        </div>
        <div className="row">
          <div className="col m4 s12">
            <div className="colorBox" style={this.dynamics}></div>
          </div>
          <div className="col m4 s12">
            <div className="colorBox" style={this.materialDynamics}></div>
          </div>
        </div>
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