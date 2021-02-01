import React from 'react';
import { withTranslation } from 'react-i18next';

import './index.css';
import * as API from '../../API';

import { Input1, LanguageSelector } from '../../components';

class SignupPage extends React.Component {
	state = {
		username: '',
		displayname: '',
		password: '',
		password2: '',
		agree: false,
		loading: false,
		validationErrors: {},
		passwordError: ''
	};

	onChange = ({ target }) => {
		const { t } = this.props;
		const { name, value } = target;
		const validationErrors = { ...this.state.validationErrors };
		let passwordError = '';

		delete validationErrors[name];

		if (name === 'password2' && value !== this.state.password) passwordError = t('Password mismatch');

		this.setState({ [name]: value, validationErrors, passwordError });
	};

	onClickSignup = async d => {
		d.preventDefault();

		if (this.state.loading) return;
		this.setState({ loading: true });

		const res = await API.userSignUp(this.state);
		if (res.status) { //200 ok

		}
		else { //error
			console.log("🚀 ~ file: index.js ~ line 49 ~ SignupPage ~ res.data.response.data", res.data.response.data);
			this.setState({ validationErrors: res.data.response.data.type === 'validerr' ? res.data.response.data.errors : {} });
		}

		this.setState({ loading: false });
	};

	render() {
		const { validationErrors } = this.state;
		const { t } = this.props;

		return (
			<div className="container">
				<form>
					<h1>{t('Sign Up')}</h1>

					<Input1
						placeholder={t('Username')}
						name="username"
						value={this.state.username}
						onChange={this.onChange}
						error={validationErrors.username}
					/>
					<Input1
						placeholder={t('Display Name')}
						name="displayname"
						value={this.state.displayname}
						onChange={this.onChange}
						error={validationErrors.displayname}
					/>
					<Input1
						placeholder={t('Password')}
						name="password"
						type="password"
						value={this.state.password}
						onChange={this.onChange}
						error={validationErrors.password}
					/>
					<Input1
						placeholder={t('Repeat Password')}
						name="password2"
						type="password"
						value={this.state.password2}
						onChange={this.onChange}
						error={this.state.passwordError}
					/>


					<button
						type="button"
						className="btn btn-primary"
						data-bs-toggle="tooltip"
						data-bs-placement="top"
						title="Sign Up"
						disabled={this.state.loading}
						onClick={this.onClickSignup}
						style={{ width: '20%', height: "50px" }}
					>
						{
							this.state.loading ?
								<div className="spinner-border text-light" role="status">
									<span className="visually-hidden">Loading...</span>
								</div> :
								t('Sign Up')
						}
					</button>
				</form>

				<LanguageSelector />
			</div>
		);
	}
};

const x = withTranslation()(SignupPage);
export { x as SignupPage };
