'use strict';

import React from 'react';
import { ColorPicker } from './components'; // Looks automatically for index.js inside components folder

// let ColorPicker = Components.ColorPicker;

export default class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <div>
        <h1> Material Colors </h1>
        <body> Input a hex representation of a color here, 
          and the closest material color will be returned. </body>
        <ColorPicker default='88ff00'/>
      </div>
    );
  }

  static PropTypes = {}

  static defaultProps = {}

  static contextTypes = {}
}