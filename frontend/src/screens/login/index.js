import React from 'react';
import { withTranslation } from 'react-i18next';

import './index.css';
import * as API from '../../API';

import { Input1, LanguageSelector } from '../../components';

class LoginPage extends React.Component {
	state = {
		username: '',
		password: '',
		loading: false,
	};

	onChange = ({ target }) => {
		const { name, value } = target;
		this.setState({ [name]: value });
	};

	onClickLogin = async d => {
		d.preventDefault();

		if (this.state.loading) return;
		this.setState({ loading: true });


		this.setState({ loading: false });
	};

	render() {
		const { t } = this.props;

		return (
			<div className="container">
				<form>
					<h1>{t('Login')}</h1>

					<Input1
						placeholder={t('Username')}
						name="username"
						value={this.state.username}
						onChange={this.onChange}
					/>
					<Input1
						placeholder={t('Password')}
						name="password"
						type="password"
						value={this.state.password}
						onChange={this.onChange}
					/>

					<button
						type="button"
						className="btn btn-primary"
						data-bs-toggle="tooltip"
						data-bs-placement="top"
						title="Sign Up"
						disabled={this.state.loading}
						onClick={this.onClickLogin}
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

const x = withTranslation()(LoginPage);
export { x as LoginPage };
