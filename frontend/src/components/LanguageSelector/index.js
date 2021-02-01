import React from 'react';
import { withTranslation } from 'react-i18next';

import './index.css';
import * as API from '../../API';

class LanguageSelector extends React.Component {
	changeLanguage = lng => {
		this.props.i18n.changeLanguage(lng);
		API.changeLanguage(lng);
	};


	render() {
		return (
			<div className="lngContainer">
				<label className="trText" onClick={() => this.changeLanguage('tr')}>TR</label>
				<label className="enText" onClick={() => this.changeLanguage('en')}>EN</label>
			</div>
		);
	}
};

const x = withTranslation()(LanguageSelector);
export { x as LanguageSelector };
